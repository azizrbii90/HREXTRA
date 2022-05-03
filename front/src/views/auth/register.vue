<template>
  <div  class="flex items-center justify-center min-h-[570px] p-8">
      <notifications group="notif" />
      <div class="px-8 py-6 text-left shadow-md">
        <h3 class="text-2xl font-bold">Welcome in Your Company</h3>
        <form @submit.prevent="_register">
          <div class="mt-4">
            <div>
              <label class="block" for="email">Email</label>
              <input
                type="text"
                placeholder="Email"
                v-model="data.email"
                required
                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
              />
            </div>
            <div class="mt-4">
              <label class="block" for="username">Username</label>
              <input
                type="text"
                placeholder="Username"
                v-model="data.username"
                required
                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
              />
            </div>
            <div class="mt-4">
              <label class="block" for="dateOfBirth">Birthday</label>
              <input
                type="date"
                placeholder="dateOfBirth"
                v-model="data.dateOfBirth"
                required
                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
              />
            </div>
            <div class="mt-4">
              <label class="block" for="phone">Phone</label>
              <input
                type="tel"
                placeholder="Phone"
                v-model="data.phone"
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
            <div class="mt-4">
              <label class="block">Confirm password</label>
              <input
                type="password"
                placeholder="Confirm password"
                v-model="confirmPassword"
                required
                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
              />
            </div>
            <div class="flex items-stretch py-5 justify-between">
              <button
                class="px-6 py-3 text-white bg-blue-600 rounded-lg hover:bg-blue-900"
                type="submit"
              >
                Register
              </button>
              <div class="text-right cursor-pointer mt-2">
              <span @click="this.$router.push('/sign-in')" class="text-sm text-blue-600"
                >Sign IN?</span
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
                email : '@azizcompany.com',
                password : '',
                phone : '',
                username : '',
                dateOfBirth : '',
                role : ["user"]
            },
            confirmPassword : ''
        }
    },

    methods : {
        _register (e) {
            e.preventDefault()
            const self = this
            const email = this.data.email.split('@')[1]
            if(email !== "azizcompany.com") {
              this.$notify({
                  title: "Register",
                  text: "You can't register with this email : your email must be given from ower company : ***@azizcompany.com!",
                  type: 'error',
                });
            } else if(this.data.password!==this.confirmPassword) {
                this.$notify({
                  title: "Register",
                  text: "Password and confirm password must be the same!",
                  type: 'error',
                });
            } else {
                this.$store.dispatch("register", this.data).then(data => {
                  if(data.message==="user registred succussfelly") {
                    this.$notify({
                      title: "Register",
                      text: "You succussfully registred, welcome!",
                      type: 'success',
                    });
                    setTimeout(function () {
                      self.$router.push('/sign-in');
                    }, 2000);
                  } else {
                    this.$notify({
                      title: "Register",
                      text: "A problem has occured : username and email must be unique, Please try again!",
                      type: 'error',
                    });
                  }
                })
            }
        }
    }
}

</script>
