<template>
  <div>
    <h2>Ajouter un pays</h2>
    <CountryForm />
  </div>
</template>

<script setup>
import CountryForm from "@/components/CountryForm.vue";
</script>



<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
