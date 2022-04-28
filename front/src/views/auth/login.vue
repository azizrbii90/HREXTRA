<template>
  <div class="w-1/3">
      <div class="px-8 py-6 text-left shadow-lg">
        <h3 class="text-2xl font-bold">Login to your account</h3>
        <form @submit.prevent="_login">
          <div class="mt-4">
            <div>
              <label class="block">Username</label>
              <input
                type="text"
                placeholder="Username"
                v-model="data.username"
                required
                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
              />
            </div>
            <div class="mt-4">
              <label class="block">Password</label>
              <input
                type="password"
                placeholder="Password"
                v-model="data.password"
                required
                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
              />
            </div>
            <div class="flex items-stretch py-7 justify-between">
              <button
                class="px-6 text-white bg-blue-600 rounded-lg hover:bg-blue-900"
                type="submit"
              >
                Login
              </button>
              <div class="text-right">
              <a class="text-sm text-blue-600 cursor-pointer"
                >Forgot password?</a
              ><br>
              <span @click="this.$router.push('/sign-up')" class="text-sm text-blue-600 cursor-pointer"
                >Sign UP?</span
              >
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
</template>

<script>

export default {
    data() {
        return {
            data : {
                username : '',
                password : ''
            }
        }
    },

    methods : {
        _login (e) {
            e.preventDefault()
            const self = this
            this.$store.dispatch("login", this.data).then(data => {
                if(data) {
                  self.$router.push('/dashboard');
                } else {
                  this.$notify({
                  title: "Login",
                  text: "Wrong credentials!",
                  type: 'error',
                  });
                }
            })
        }
    }
}

</script>
