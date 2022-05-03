export default {
    computed: {
       presences() {return this.$store.getters.getCurrentPresences;}
    }
}