<template>
 
<div id="resp-table">
   <div id="resp-table-subheader">
          <div class="table-header-cell">Id</div>
          <div class="table-header-cell">Ejercicio</div>
          <div class="table-header-cell">Peso</div>
          <div class="table-header-cell">Reps.</div>
          <div class="table-header-cell">Tiempo</div>
          <div class="table-header-cell">Distancia</div>
          <div class="table-header-cell">Observaciones</div>
    </div>
    <div id="resp-table-body">
        <div class="resp-table-row" v-for="(registro,index) in registros" v-bind:key="index">
            <div class="table-body-cell"> {{ registro.id }}</div>
            <div class="table-body-cell"> {{ registro.ejercicio }}</div>
            <div class="table-body-cell"> {{ registro.peso }}</div>
            <div class="table-body-cell"> {{ registro.repeticiones }}</div>
            <div class="table-body-cell"> {{ registro.tiempo }}</div>
            <div class="table-body-cell"> {{ registro.distancia }}</div>
            <div class="table-body-cell"> {{ registro.observaciones }}</div>
        </div>
    </div>
</div>
</template>

<script>
import RegistroDataService from "../../services/RegistroDataService";

export default {
  name: "registros-list",
  data() {
    return {
      registros: [],
      currentRegistro: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveRegistros() {
       console.log("retrieveRegistros list");
      RegistroDataService.getAll()
        .then(response => {
          this.registros = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveRegistros();
      this.currentRegistro = null;
      this.currentIndex = -1;
    },

    setActiveRegistro(registro, index) {
      this.currentRegistro = registro;
      this.currentIndex = index;
    },

    removeAllRegistros() {
      RegistroDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    searchName() {
      console.log("findByNombre");     
    }
  },
  mounted() {
    this.retrieveRegistros();
  }
};
</script>

<style>
  #resp-table-subheader {
    display: table-header-group;
    background-color:gainsboro;
    font-weight: bold;
    text-align: center;
    font-size: 15px;
  }
</style>  