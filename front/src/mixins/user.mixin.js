export default {
    computed: {
       user() {
           return this.$store.getters.getCurrentUser;
        }
    }
}