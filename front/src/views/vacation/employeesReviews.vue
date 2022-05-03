<template>
    <div class="flex min-h-[570px] p-10">
    <div class="w-full">
      <h1 class="text-2xl">Employees Reviews</h1><br>
      <vue-good-table 
      :columns="columns" 
      :rows="users"
     
      :pagination-options="{
        enabled: true,
        mode: 'records',
        perPage: 6,
        nextLabel: 'next',
        prevLabel: 'prev',
        rowsPerPageLabel: 'Rows per page',
        ofLabel: 'of',
        pageLabel: 'page', // for 'pages' mode
        allLabel: 'All',
       }"
        :search-options="{
          enabled: true,
          externalQuery: searchTerm,
        }"
 />
    </div>
  </div>
</template>

<script>
import 'vue-good-table-next/dist/vue-good-table-next.css'
import { VueGoodTable } from 'vue-good-table-next';
import UsersMixin from "@/mixins/users.mixin.js";

export default {
      mixins: [UsersMixin],


    components: {
        VueGoodTable,
    },

     data() {
        return {
      columns: [
        {
          label: "First Name",
          field: "nom",
          },
        {
          label: "Last Name",
          field: "prenom",
        },
        {
          label: "Days",
          field: "dureeConges",
          sortable: true,
        },
        {
          label: "Consumed days",
          field: "joursConges",
          sortable: false,
        },
        {
          label: "Remaining days",
          field: "soldeConges",
        },
        
      ]
    };
  },

  
}
</script>