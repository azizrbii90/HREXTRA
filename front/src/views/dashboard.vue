<template>
    <div class="grid grid-cols-5">
        <div>
        <Sidebar />
        </div>
        <div class="col-span-4">
        <router-view></router-view>
        </div>
    </div>
</template>

<script>
import Sidebar from "../components/shared/sidebar.vue";
import UserMixin from "@/mixins/user.mixin.js";

export default {
    
    mixins: [UserMixin],

    components: {
         Sidebar
    },
  
    created () {
        if (localStorage.token) {
            this.$store.dispatch("getUserFromToken").then((data) => {
                this.$store.dispatch("ListVacations", this.user.idUser)
                this.$store.dispatch("ListPresences", this.user.idUser)

                //rh
                this.$store.dispatch("ListUsers")
                this.$store.dispatch("ListAllVacations")
            })
        }
  }
}
</script>