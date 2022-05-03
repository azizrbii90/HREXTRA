<template>
    <nav
      class="bg-slate-50 border-gray-200 px-2 sm:px-4 py-2.5 rounded dark:bg-gray-800 sticky top-0 z-50"
    >
      <div
        class="container flex flex-wrap justify-between items-center mx-auto"
      >
        <a @click="this.$router.push('/')" href="#" class="flex items-center">
          <span
            class="self-center text-xl font-semibold whitespace-nowrap dark:text-white"
            >HREXTRA</span
          >
        </a>
        <div
          class="hidden justify-between items-center w-full md:flex md:w-auto md:order-1"
          id="mobile-menu-3"
        >
          <ul
            class="flex flex-col mt-4 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium"
          >
            <li  @click="this.$router.push('/')">
              <a
                href="#"
                class="block py-2 pr-4 pl-3 text-gray-700 border-b border-gray-100 hover:bg-gray-50 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700"
                >Home</a
              >
            </li>
            <li @click="this.$router.push('/candidate')">
              <a
                href="#"
                class="block py-2 pr-4 pl-3 text-gray-700 border-b border-gray-100 hover:bg-gray-50 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 md:dark:hover:text-white dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700"
                >Candidate Area</a
              >
            </li>
            <li v-if="exist===false" @click="this.$router.push('sign-in')">
              <a
                href="#"
                class="block py-2 pr-4 pl-3 text-gray-700 border-b border-gray-100 hover:bg-gray-50 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700"
                >Employee Area</a
              >
            </li>
            <li v-else @click="_logout">
              <a
                class="block py-2 pr-4 pl-3 text-gray-700 border-b border-gray-100 hover:bg-gray-50 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700"
                >Logout</a
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>
</template>

<script>
import UserMixin from "@/mixins/user.mixin.js";

export default {

  mixins: [UserMixin],

  data() {
      return {
        exist : false
      }
  },

  watch: {
    user() {
      if(this.user===null) {
        this.exist = false
      } else {
        this.exist = true
      }
    }
  },

  methods : {
    
    _logout () {
      let self = this
      this.$store.dispatch("logout").then(data => {
            localStorage.removeItem("token");
            self.$router.push('/');
      })
    }
  }
}
</script>
