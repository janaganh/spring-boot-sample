<template>
  <div id="personals" class="container">
    <header>
      <h2>Personal</h2>
    </header>
    <main>
      <div class="list-group">
        <a v-for="personal in personals" v-bind:key="'personal-'+personal.id" href="#" class="list-group-item list-group-item-action">
          {{ personal.name }}
        </a>

        <a href="#" class="list-group-item list-group-item-action">
          <button v-on:click="calculate()" type="button" class="btn btn-primary btn-sm">Calculate</button>
          <span><label>{{commission}}</label></span>
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
  name: 'Personals',
  data () {
    return {
      personals: [],
      recruiterId: '',
      commission: ''
    }
  },
  mounted: function () {
    // `this` points to the vm instance
    this.recruiterId = this.$route.params.recruiterId
    this.fetchPersonals()
  },
  methods: {
    fetchPersonals () {
      axios
        .get('/recruitment/recruiters/' + this.recruiterId + '/personals')
        .then(response => {
          this.personals = []
          this.commission = ''
          this.personals = response.data
        }
        )
    },
    calculate () {
      axios
        .get('/recruitment/recruiters/' + this.recruiterId + '/calculate')
        .then(response => {
          this.commission = response.data.commission
        }
        )
    }
  }
}
</script>

<style scoped>
#personals {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
  margin-top: 60px;
  width: 50%;
}

label {
  padding: 10px;
  font-size: 2em;
}
</style>
