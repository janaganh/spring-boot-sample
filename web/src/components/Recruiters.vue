<template>
  <div id="recruiters" class="container">
    <header>
      <h2>Recruiters</h2>
    </header>
    <main>
      <div class="list-group">
        <a v-on:click="listPersonal(recruiter.id)" v-for="recruiter in recruiters" v-bind:key="'recruiter-'+recruiter.id" href="#" class="list-group-item list-group-item-action">
          {{ recruiter.name }}
        </a>
      </div>
    </main>
    <footer>
    </footer>
  </div>
</template>

<script>
import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  name: 'Recruiters',
  data () {
    return {
      recruiters: []
    }
  },
  mounted: function () {
    // `this` points to the vm instance
    this.fetchRecruiters()
  },
  methods: {
    fetchRecruiters () {
      axios
        .get('/recruitment/recruiters')
        .then(response => {
          this.recruiters = []
          this.recruiters = response.data
        }
        )
    },
    listPersonal (id) {
      this.$router.push({name: 'Personals', params: {'recruiterId': id}})
    }
  }
}
</script>

<style scoped>
#recruiters {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
  margin-top: 60px;
  width: 50%;
}
</style>
