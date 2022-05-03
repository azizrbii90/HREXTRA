<template>
  <div class="flex items-center justify-center min-h-[570px] p-8">
    <form @submit.prevent="_submit">
        <div class="grid grid-cols-2 gap-6">
            <div class="shadow-md bg-slate-100 p-5">
              <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-first-name">
                    First Name
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-first-name" type="text"
                  placeholder="First Name"
                  v-model="data.nom"
                  required>
                </div>
              </div>
               <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-last-name">
                    Last Name
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-last-name" type="text"
                  placeholder="Last Name"
                  v-model="data.prenom"
                  required>
                </div>
              </div>
               <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-email">
                    Email
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-email" type="email"
                  placeholder="Email"
                  v-model="data.email"
                  required>
                </div>
              </div>
               <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-birthday">
                    Birthday
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-birthday" type="date"
                  placeholder="Birthday"
                  v-model="data.dateOfBirth"
                  required>
                </div>
              </div>
              <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-resume">
                    Resume
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-resume" type="file"
                  placeholder="Resume"
                  @change="onResumeSelected"
                  required>
                </div>
              </div>
             <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-phone">
                    Phone
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-phone" type="tel"
                  placeholder="Phone"
                  v-model="data.phone"
                  required>
                </div>
              </div>
             
            </div>
        <!-- ... -->
            <div class="shadow-md bg-slate-100 p-5">
              <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-level">
                    Level
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-level" type="text"
                  placeholder="Level"
                  v-model="data.niveauEtud"
                  required>
                </div>
              </div>
              <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-diploma">
                    Diploma
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-diploma" type="text"
                  placeholder="Diploma"
                  v-model="data.titreDiplome"
                  required>
                </div>
              </div>
              <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-university">
                    University
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-university" type="text"
                  placeholder="University"
                  v-model="data.university"
                  required>
                </div>
              </div>
              <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-years-experience">
                    Years experience
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-years-experience" type="text"
                  placeholder="Yars experience"
                  v-model="data.niveauExp"
                  required>
                </div>
              </div>
              <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-cover-letter">
                    Cover letter
                  </label>
                </div>
                <div class="md:w-2/3">
                  <input 
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" id="inline-cover-letter" type="file"
                  placeholder="Resume"
                  @change="onCoverLetterSelected"
                  required>
                </div>
              </div> 
              <div class="md:flex md:items-center mb-6">
                <div class="md:w-1/3">
                  <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-cover-letter">
                  </label>
                </div>
                <div class="md:w-2/3">
                  <button class="px-6 py-2 w-full text-white bg-blue-600 rounded-lg hover:bg-blue-900" type="submit">
                    Submit
                  </button>
                </div>
              </div> 
            </div>   
        </div>
    </form>
  </div>
</template>

<script>
import { AddCandidateService } from '../../services/candidate.service';

export default {

    data () {
        return {
            data : {

            },
            resumeFile : '',
            coverLetterFile : ''
        }
    },

    methods : {
        
        onResumeSelected(e) {
             this.resumeFile = e.target.files[0];
        },

        onCoverLetterSelected(e) {
             this.coverLetterFile = e.target.files[0];
        },

        _submit(e) {
            e.preventDefault();
            var formData = new FormData();
            formData.append("candidate", JSON.stringify(this.data));
            formData.append("cv_file", this.resumeFile);
            formData.append("motiv_letter_file", this.coverLetterFile);
            
            AddCandidateService(formData).then((data) => {
              if(data==="candiate is saved") {
                this.$notify({
                      title: "Application",
                      text: "You succussfully submit it, thank you!",
                      type: 'success',
                    });
              this.data = {}
              } else {
                this.$notify({
                      title: "Application",
                      text: "There is a problem, try again!",
                      type: 'error',
                    });
              }
            });
        }
    }
}
</script>