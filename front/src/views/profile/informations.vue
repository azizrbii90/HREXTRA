<template>
  <div class="flex items-center justify-center min-h-[570px] p-8">
    <form @submit.prevent="_submit">
      <div class="grid grid-cols-2 gap-6">
        <div class="shadow-md bg-slate-100 p-5">
          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-first-name"
              >
                First Name
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-first-name"
                type="text"
                placeholder="First Name"
                v-model="data.nom"
                required
              />
            </div>
          </div>
        
          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-birthday"
              >
                Birthday
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-birthday"
                type="date"
                placeholder="Birthday"
                v-model="data.dateOfBirth"
                required
              />
            </div>
          </div>
               <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-level"
              >
                Country
              </label>
            </div>
            <div class="md:w-2/3">
              <select
                v-model="data.pays"
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                aria-label="Default select example"
              >
                <option selected value="Tunisia">Tunisia</option>
                <option value="Algeria">Algeria</option>
                <option value="Marooc">Marooc</option>
              </select>
            </div>
          </div>
       
          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-last-name"
              >
                City
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-last-name"
                type="text"
                placeholder="Last Name"
                v-model="data.ville"
                required
              />
            </div>
          </div>
          
        </div>
        <!-- ... -->

        <div class="shadow-md bg-slate-100 p-5">
              <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-last-name"
              >
                Last Name
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-last-name"
                type="text"
                placeholder="Last Name"
                v-model="data.prenom"
                required
              />
            </div>
          </div>
            <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-level"
              >
                Nationality
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-level"
                type="text"
                placeholder="Level"
                v-model="data.nationality"
                required
              />
            </div>
          </div>
          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-phone"
              >
                Phone
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-phone"
                type="tel"
                placeholder="Phone"
                v-model="data.phone"
                required
              />
            </div>
          </div>
        
              <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-last-name"
              >
                Address
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-last-name"
                type="text"
                placeholder="Last Name"
                v-model="data.adresse"
                required
              />
            </div>
          </div>
       
          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-cover-letter"
              >
              </label>
            </div>
            <div class="md:w-2/3">
              <button
                class="px-6 py-2 w-full text-white bg-blue-600 rounded-lg hover:bg-blue-900"
                type="submit"
              >
                Submit
              </button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import UserMixin from "@/mixins/user.mixin.js";

export default {
  mixins: [UserMixin],

  data() {
    return {
      data: {},
    };
  },

  mounted() {
    this.data = this.user;
  },
  watch: {
    user() {
      this.data = this.user;
    },
  },

  methods: {
    _submit() {
      this.$store.dispatch("updateInfoUser", this.data).then((data) => {
        if (data) {
          this.$notify({
            title: "Personnel Informations",
            text: "Succussfully updated!",
            type: "success",
          });
        } else {
          this.$notify({
            title: "Personnel Informations",
            text: "Failed Updated!",
            type: "error",
          });
        }
      });
    },
  },
};
</script>
