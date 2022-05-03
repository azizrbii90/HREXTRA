<template>
  <div>
    <Header />
    <notifications />
    <div class="min-h-[570px]">
    <router-view />
    </div>
  </div>  
</template>

<script>
import Header from "./components/shared/header.vue";

export default {

  //    <div class="flex items-center justify-center min-h-[607px] p-6">
  components: {
         Header
  },
}
</script>

