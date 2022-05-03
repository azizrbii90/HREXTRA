<template>
  <div class="flex min-h-[570px] p-10">
    <div class="w-full">
      <h1 class="text-2xl">Last Requests</h1><br>
      <vue-good-table 
      :columns="columns" 
      :rows="vacations"
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
       }"/>
    </div>
  </div>
</template>

<script>
import 'vue-good-table-next/dist/vue-good-table-next.css'
import { VueGoodTable } from 'vue-good-table-next';

import VacationMixin from "@/mixins/vacation.mixin.js";


export default {
    
    mixins: [VacationMixin],

    components: {
        VueGoodTable,
    },
    
    data() {
        return {
      columns: [
        {
          label: "Request Date",
          field: "createdAt",
          width: "15%",
          sortable: true,
        },
        {
          label: "Type",
          field: "typeConge",
          sortable: true,
        },
        {
          label: "Start Date",
          field: "debutConge",
          width: "15%",
          sortable: true,
        },
        {
          label: "End Date",
          field: "finConge",
          width: "15%",
          sortable: true,
        },
        {
          label: "Status",
          field: "statusOfRequest",
          sortable: true,
        },
      ]
    };
  },
};
</script>
