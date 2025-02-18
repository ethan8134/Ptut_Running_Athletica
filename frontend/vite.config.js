import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  // Change build paths to make them Maven compatible
  build: {
    outDir: 'target/dist',
    assetsDir: 'static',
  },
  // Utile uniquement pour le serveur de développement qui tourne sur un autre port que le backend
  server: {
    proxy: { // On redirige toutes les requêtes au backend vers le serveur de développement java
      '/api': { // L'API REST autogénérée, correspond à la config du backend spring.data.rest.base-path dans application.properties
        target: 'http://localhost:8989', // correspond à la config du backend server.port dans application.properties
        changeOrigin: true,
      },
      '/rest': { // L'adresse des contrôleurs ad-hoc pour les services métier
        target: 'http://localhost:8989', // correspond à la config du backend server.port dans application.properties
        changeOrigin: true,
      },
    },
  },
})
