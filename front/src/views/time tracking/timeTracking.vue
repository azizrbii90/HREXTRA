<template>
<div class="flex justify-center min-h-[570px]">
    <div class="w-4/6 mt-4">
  <v-date-picker is-expanded v-model="selectedDate" :attributes="attrs" />
  </div>
  </div>
</template>
<script>
import PresenceMixin from "@/mixins/presence.mixin.js";
import UserMixin from "@/mixins/user.mixin.js";

import moment from "moment";

export default {
  mixins: [PresenceMixin, UserMixin],

  data() {
    const date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth();

    return {
      selectedDate: new Date(),
      attrs: [
      ],
    };
  },

  mounted() {
    for (let i = 0; i < this.presences.length; i++) {
      let newObj = {
        highlight: { color: "purple", fillMode: "outline" },
        popover: { label: this.presences[i].nbrheures + " houres" },
        idPresence: this.presences[i].idPresence,
        nbrheures: this.presences[i].nbrheures,
        dates: this.presences[i].day,
      };
      this.attrs.push(newObj);
    }
  },
  /*data() {
 
  return {
    
     
      presences : [{idPresence : 1, localDate :new Date(2022, 5, 01), nbrheures : 8}],
      date : new Date(),

  };
},*/
  watch: {
    selectedDate() {
      let sysDate = new Date();
      let input = 0;
      let firstTime = true;
      if ((moment(this.selectedDate).format("L") === moment(sysDate).format("L")) || this.selectedDate===null) {
          if(this.attrs.length>0) {
        if (moment(this.attrs[this.attrs.length - 1]?.dates).format("L") === moment(sysDate).format("L")) {
          input = this.attrs[this.attrs.length - 1]?.nbrheures || 0;
          firstTime = false;
        }
          }
     
        let nbrHours = prompt("Please enter number of hours for : " +moment(this.selectedDate).format("L"),input);
        if (nbrHours == null || nbrHours == "") {
          console.log("not added");
        } else {
          if (!firstTime) {
            if (parseInt(nbrHours) > 0) {
              this.attrs[this.attrs.length - 1].nbrheures = nbrHours;
              this.attrs[this.attrs.length - 1].popover.label = nbrHours+" houres"
              console.log("hhe ",this.attrs)
              let x = Object.assign({}, this.attrs[this.attrs.length - 1])
              delete x.highlight
            const format3 = "YYYY-MM-DD"
            x.day = moment(x.dates).format(format3)
            delete x.dates
            delete x.popover
            x.user = this.user
             this.$store.dispatch("UpdatePresence",  x).then((data) => {
                if (data) {
                  this.$notify({
                    title: "Presence Request",
                    text: "Presence succussfully updated!",
                    type: "success",
                  });
                } else {
                  this.$notify({
                    title: "Presence Request",
                    text: "Presence not updated!",
                    type: "error",
                  });
                }
              });
            }
          } else {
              console.log("hehheheh ")
            let newObj = {
              highlight: {
                color: "purple",
                fillMode: "solid",
              },
              popover: { label: nbrHours+" houres" },
              dates: sysDate,
              nbrheures: nbrHours,
            };
            this.attrs.push(Object.assign({}, newObj));
            delete newObj.highlight
            const format2 = "YYYY-MM-DD"
            newObj.day = moment(newObj.dates).format(format2)
            delete newObj.dates
            this.$store.dispatch("AddPresence", { presence: newObj, idUser: this.user.idUser}).then((data) => {
                if (data) {
                  this.$notify({
                    title: "Presence Request",
                    text: "Presence succussfully added!",
                    type: "success",
                  });
                } else {
                  this.$notify({
                    title: "Presence Request",
                    text: "Presence not added!",
                    type: "error",
                  });
                }
              });
          }
        }
      } else {
           this.$notify({
                    title: "Presence Request",
                    text: "You can only update or add only sysdate : "+moment(sysDate).format("L"),
                    type: "warn",
                  });
      }
    },

    presences() {
        for (let i = 0; i < this.presences.length; i++) {
      let newObj = {
        highlight: { color: "purple", fillMode: "outline" },
        popover: { label: this.presences[i].nbrheures + " houres" },
        idPresence: this.presences[i].idPresence,
        nbrheures: this.presences[i].nbrheures,
        dates: this.presences[i].day,
      };
      this.attrs.push(newObj);
    }
    }
  },
};
</script>

<style></style>
