<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by title"
          v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
            @click="searchName"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <h4>Ejercicios</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(ejercicio, index) in ejercicios"
          :key="index"
          @click="setActiveEjercicio(ejercicio, index)"
        >
          {{ ejercicio.id }} - {{ ejercicio.nombre }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllEjercicios">
        Remove All
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentEjercicio">
        <h4>Detalle</h4>
        
        <div>
          <label><strong>Id:</strong></label> {{ currentEjercicio.id }}
        </div>        
        <div>
          <label><strong>Nombre:</strong></label> {{ currentEjercicio.nombre }}
        </div>
        <div>
          <label><strong>Descripcion:</strong></label> {{ currentEjercicio.descripcion }}
        </div>
        <div>
          <label><strong>Categor&iacute;a:</strong></label> {{ currentEjercicio.categoria }}
        </div>
        <div>
          <label><strong>Tipo:</strong></label> {{ currentEjercicio.tipo }}
        </div>

        <a class="badge badge-warning"
          :href="'/ejercicios/' + currentEjercicio.id"
        >
          Edit
        </a>
      </div>
      <div v-else>
        <br />
        <p>Please click on a Ejercicio...</p>
      </div>
    </div>
  </div>
</template>

<script>
import EjercicioDataService from "../../services/EjercicioDataService";

export default {
  name: "ejercicios-list",
  data() {
    return {
      ejercicios: [],
      currentEjercicio: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveEjercicios() {
       console.log("retrieveEjercicios");
      EjercicioDataService.getAll()
        .then(response => {
          this.ejercicios = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveEjercicios();
      this.currentEjercicio = null;
      this.currentIndex = -1;
    },

    setActiveEjercicio(ejercicio, index) {
      this.currentEjercicio = ejercicio;
      this.currentIndex = index;
    },

    removeAllEjercicios() {
      EjercicioDataService.deleteAll()
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
      EjercicioDataService.findByNombre(this.nombre)
        .then(response => {
          this.ejercicios = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveEjercicios();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
