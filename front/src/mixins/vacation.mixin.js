export default {
    computed: {
       vacations() {return this.$store.getters.getCurrentVacations;}
    }
}