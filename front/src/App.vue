<template>
  <div>
    <Header />
    <notifications />
    <div class="flex items-center justify-center min-h-[607px] p-6">
    <router-view />
    </div>
  </div>  
</template>

<script>
import Header from "./components/shared/header.vue";

export default {

  components: {
         Header
  },
  mounted () {
    if (localStorage.token) {
        this.$store.dispatch("getUserFromToken")
    }
  }
}
</script>

