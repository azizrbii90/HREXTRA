<template>
<div  class="flex items-center justify-center min-h-[570px] p-8">
  <div class="grid grid-cols-2 gap-6">
  <div class="shadow-md bg-slate-100 p-5">
   
    <div class="flex flex-col items-center pb-10">
      <img
        id="photoImg"
        class="mb-3 w-24 h-24 rounded-full shadow-lg"
        :src="user === null ? '' : 'http://localhost:8081'+user.photo"
        alt="Bonnie image"
      />
      <h5 class="mb-1 text-xl font-medium text-gray-900 dark:text-white">
        {{user===null ? '' : user.username}}
      </h5>
      <span class="text-sm text-gray-500 dark:text-gray-400"
        >{{user===null ? '' : user.email}}</span
      >
      <div>
        <input class="mt-5" accept="image/gif, image/jpeg, image/png" type="file" @change="onPhotoSelected" required />
      </div>
      <button
        @click="_save"
        class="px-6 py-2  mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900"
      >
        Save
      </button>
    </div>
  </div>
  <div class="flex items-center shadow-md bg-slate-100 p-5 justify-center">
    <form @submit.prevent="_updatePassword">
      <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-old-password"
              >
                Old Password
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-old-password"
                type="text"
                placeholder="Old Password"
                v-model="oldPassword"
                required
              />
            </div>
          </div>
           <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-new-password"
              >
                New Password
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-new-password"
                type="text"
                placeholder="New Password"
                v-model="newPassword"
                required
              />
            </div>
          </div>

           <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-confirm-password"
              >
                Confirm Password
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                id="inline-confirm-password"
                type="text"
                placeholder="Confirm Password"
                v-model="confirmPassword"
                required
              />
            </div>
          </div>
        <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label
                class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
                for="inline-old-password"
              >
              </label>
            </div>
            <div class="md:w-2/3">
               <button
        type="submit"
        class="px-6 py-2  mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900"
      >
        Save
      </button>
            </div>
          </div>
     
    </form>
  </div>
  </div>
  </div>
</template>

<script>
import UserMixin from "@/mixins/user.mixin.js";
import axios from 'axios'; 

export default {
    mixins: [UserMixin],
    
    data () {
        return {
            photo : '',
            confirmPassword : '',
            newPassword : '',
            oldPassword : '',
            show : false
        }
    },

     mounted() {
         if(this.user!==null)
    this.photo = this.user.photo || "";
  },
  watch: {
    user() {
      this.photo = this.user.photo || "";
    },
  },

  methods: {
      onPhotoSelected (e) {
             this.photo = e.target.files[0];
             var elementImg = document.getElementById("photoImg");
             elementImg.src= URL.createObjectURL(this.photo);
        },
      _save() {
            var formData = new FormData();
            formData.append("idUser", this.user.idUser);
            formData.append("avatar", this.photo);

             this.$store.dispatch("updateAvatarUser", formData).then((data) => {
        if (data) {
          this.$notify({
            title: "Avatar",
            text: "Succussfully updated!",
            type: "success",
          });
        } else {
          this.$notify({
            title: "Avatar",
            text: "Failed Updated!",
            type: "error",
          });
        }
      });
      }, 

      _updatePassword(e) {
        e.preventDefault();
        if(this.newPassword===this.confirmPassword) {
          axios.post('http://localhost:8081/update-password',null,{params : {
          oldPassword : this.oldPassword, newPassword : this.newPassword, confirmPassword : this.confirmPassword
        }}).then((data) => {
          if (data.data==="Password Updated successfully") {
          this.$notify({
            title: "Password",
            text: "Succussfully updated!",
            type: "success",
          });
        } else {
          this.$notify({
            title: "Password",
            text: "Failed Updated, wrong old password!",
            type: "error",
          });
        }
        })
        } else {
          this.$notify({
            title: "Password",
            text: "Confirm uour password please!",
            type: "error",
          });
        }
        
      }
  }
}
</script>
