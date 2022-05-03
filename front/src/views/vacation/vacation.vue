<template>
  <div class="flex items-center justify-center min-h-[570px]">
    <div class="px-8 py-6 text-left shadow-lg w-1/3">
      <h3 class="text-2xl font-bold">New Request</h3>
      <form @submit.prevent="_submit">
        <div class="mt-4">
          <div>
            <label class="block">Start date</label>
            <input
              type="date"
              placeholder="Start date"
              v-model="data.debutConge"
              required
              class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
            />
          </div>
          <div class="mt-4">
            <label class="block">End Date</label>
            <input
              type="date"
              placeholder="End date"
              v-model="data.finConge"
              required
              class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
            />
          </div>
          <div class="mt-4">
              <label class="block">Type</label>
              <select
                v-model="data.typeConge"
                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
                aria-label="Default select example"
              >
                <option selected>Type</option>
                <option value="Type One">Type One</option>
                <option value="Type Two">Type Two</option>
                <option value="Type Three">Type Three</option>
              </select>
          </div>
          <div class="grid place-items-end mt-4">
            <button
              class="px-6 py-2 mt-2 text-white  bg-blue-600 rounded-lg hover:bg-blue-900"
              type="submit"
            >
              Submit
            </button>
            
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import UserMixin from "@/mixins/user.mixin.js";

export default {
    
    mixins: [UserMixin],

    data () {
        return {
            data : {
              typeConge : "Type One"
            }
        }
    },

    methods : {

      _submit () {
        this.data.createdAt = new Date()
        this.$store.dispatch("AddVacation", {vacation : this.data, idUser: this.user.idUser}).then((data) => {
          if(data) {
            this.$notify({
              title: "Vacation Request",
              text: "Vacation succussfully added!",
              type: 'success',
            });
            this.$router.push("/vacations/last-requests")
          } else {
            this.$notify({
              title: "Vacation Request",
              text: "Vacation not added!",
              type: 'error',
            });
          }
        })
      }
    }
}
</script>