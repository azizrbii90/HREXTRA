<template>
    <div class="flex min-h-[570px] p-10">
    <div class="w-full">
      <h1 class="text-2xl">Employees Requests</h1><br>
      <vue-good-table 
      :columns="columns" 
      :rows="allVacations"
     
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
        }">
          <template v-slot:table-row="props">
        
     <div v-if="props.column.label == 'Status'">
    <!-- Toggle A -->
<div class="flex items-center justify-center w-full mb-12">
  
  <label 
    :for="'toogleA'+props.row.idConge"
    class="flex items-center cursor-pointer"
  >
    <!-- toggle -->
    <div class="relative">
      <!-- input -->
      <input :id="'toogleA'+props.row.idConge" type="checkbox" class="sr-only" @change="updateStatus(props.row)" :checked="props.row.statusOfRequest==='Accepted'" />
      <!-- line -->
      <div class="w-10 h-4 bg-gray-400 rounded-full shadow-inner"></div>
      <!-- dot -->
      <div class="dot absolute w-6 h-6 bg-white rounded-full shadow -left-1 -top-1 transition"></div>
    </div>
    <!-- label -->
    
  </label>
  
</div>
    </div>
  </template>
    
      </vue-good-table>
    </div>
  </div>
</template>

<script>
import 'vue-good-table-next/dist/vue-good-table-next.css'
import { VueGoodTable } from 'vue-good-table-next';
import allVacationsMixin from "@/mixins/allVacation.mixin.js";

export default {
      mixins: [allVacationsMixin],


    components: {
        VueGoodTable,
    },

   
         data() {
        return {
            requests : [],
      columns: [
        {
          label: "First Name",
          field: "user.nom",
          },
        {
          label: "Last Name",
          field: "user.prenom",
        },
        {
          label: "Period",
          field: "duree",
          sortable: true,
        },
        {
          label: "Start day",
          field: "debutConge",
          sortable: false,
        },
        {
          label: "End day",
          field: "finConge",
        },
         {
          label: "Type",
          field: "typeConge",
        },

        {
            label: "Status",
            field: "statusOfRequest",
            html : true
        }
        
      ]
    };
  },

  methods: { 

      updateStatus(vacation) {
          var e = document.getElementById("toogleA"+vacation.idConge)

         const ch =  e.checked===true ? 'Are you sure? vacation will be accepted' : 'Are you sure? vacation will be refused'
           
           if(window.confirm(ch)){
                if (e.checked===true)   
                vacation.statusOfRequest = "Accepted"
                else 
                vacation.statusOfRequest = "Refused"
                this.$store.dispatch("UpdateVacation",  vacation).then((data) => {
                if (data) {
                  this.$notify({
                    title: "Vacation Request",
                    text: "Vacation succussfully updated!",
                    type: "success",
                  });
                } else {
                  this.$notify({
                    title: "Vacation Request",
                    text: "Vacation not updated!",
                    type: "error",
                  });
                }
              });
           } else {
               e.checked = !e.checked;
           }
      }
  }

  
}
</script>

<style>
input:checked ~ .dot {
  transform: translateX(100%);
  background-color: #48bb78;
}

/* Toggle B */
input:checked ~ .dot {
  transform: translateX(100%);
  background-color: #48bb78;
}
</style>