export default {
    computed: {
       users() {return this.$store.getters.getCurrentUsers;}
    }
}