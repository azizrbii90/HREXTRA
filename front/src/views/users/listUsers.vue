<template>
    <div class="flex min-h-[570px] p-10">
    <div class="w-full">
      <h1 class="text-2xl">{{type==="actual" ? 'Actual Employees' : 'Archived Employees'}}</h1><br>
      <vue-good-table 
      :columns="columns" 
      :rows="employees"
     
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
       >
       <template v-slot:table-row="props">
        
    <div v-if="props.column.label == ' '">
          <img class="w-10 h-10 rounded-full"  :src="props.row === null ? '' : 'http://localhost:8081'+props.row.photo">

    </div>
     <div v-if="props.column.label == 'Actions'">
       <button class="bg-green-300 m-1	px-1 py-1 hover:bg-grey text-grey-darkest font-bold rounded inline-flex items-center">
<svg class="w-6 h-6 bg-white" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"></path><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"></path></svg>
</button>
<button class="bg-cyan-400 m-1	 hover:bg-grey text-grey-darkest font-bold py-1 px-1 rounded inline-flex items-center">
<svg class="w-6 h-6 bg-white" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z"></path></svg>
</button>
<button @click="_archiveUser(props.row,props.index)" class="bg-rose-500 m-1 	p-1 hover:bg-grey text-grey-darkest font-bold rounded inline-flex items-center">
  <svg class="w-6 h-6 bg-white" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16"></path></svg>
</button>
    </div>
  </template>
      </vue-good-table>
    </div>
  </div>
</template>

<script>
import 'vue-good-table-next/dist/vue-good-table-next.css'
import { VueGoodTable } from 'vue-good-table-next';
import UsersMixin from "@/mixins/users.mixin.js";

export default {
      mixins: [UsersMixin],
        props:['type'],


    components: {
        VueGoodTable,
    },

     data() {
        return {
          employees: [],
      columns: [
        {
          label: " ",
          field: "photo",
          html: true
          },
        {
          label: "First Name",
          field: "nom",
          sortable: true,
        },
        {
          label: "Last Name",
          field: "prenom",
          sortable: true,
        },
        {
          label: "Phone",
          field: "phone",
          sortable: true,
        },
        {
          label: "Job",
          field: "poste",
          sortable: true,
        },
        {
          label: "Email",
          field: "email",
          width: "15%",
          sortable: true,
        },
        {
          label: "Actions",
          field: "photo",
          html: true
        },
      ]
    };
  },

  mounted () {
    console.log("type ",this.type)
    if(this.type==="actual") {
       this.employees = this.users.filter(obj => {
  return obj.archived === 0;
  });

    } else {
        this.employees = this.users.filter(obj => {
  return obj.archived === 1;
  });
    }
 
  }, 

  watch: {
    users() {
          console.log("type ",this.type)

       if(this.type==="actual") {
       this.employees = this.users.filter(obj => {
  return obj.archived === 0;
  });

    } else {
        this.employees = this.users.filter(obj => {
  return obj.archived === 1;
  });
    }
    },
    type() {
          console.log("type ",this.type)

       if(this.type==="actual") {
       this.employees = this.users.filter(obj => {
  return obj.archived === 0;
  });

    } else {
        this.employees = this.users.filter(obj => {
  return obj.archived === 1;
  });
    }
    }
  },

  methods : {
    _archiveUser(user,index) {
      const ch =  user.archived===1 ? 'Are you sure? user will be unarchived' : 'Are you sure? user will be archived'
      if(window.confirm(ch)){
        this.employees.splice(index,1)
        user.archived = user.archived===1 ? 0 : 1
         this.$store.dispatch("UpdateUser", user).then((data) => {
        if (data) {
          this.$notify({
            title: "Manage users",
            text: "Succussfully updated!",
            type: "success",
          });
        } else {
          this.$notify({
            title: "Manage users",
            text: "Failed Updated!",
            type: "error",
          });
        }
      });
      }
    }
  }
}
</script>