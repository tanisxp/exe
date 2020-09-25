<template>
  <div v-if="currentRegistro" class="edit-form">
    <h4>Ejercicio</h4>
    <form>

	<div>
	  	<span >
	        <label for="title">Id</label>
	     
	      </span>    
	    
	      <span >
	        <label for="title">Ejercicio</label>
	       
	      </span>
	      
	      <span >
	        <label for="description">Fecha</label>
	       
	      </span>
	
	    <span >
	        <label for="title">Reps.</label>
	       
	    </span>
	
	    <span >
	        <label for="description">Peso</label>
	       
	    </span>
    </div>

<!--
      <div class="form-group">
        <label for="title">Id</label>
        <input type="text" class="form-control" id="id"
          v-model="currentRegistro.id"
        />
      </div>    
    
      <div class="form-group">
        <label for="title">Ejercicio</label>
        <input type="text" class="form-control" id="ejercicio"
          v-model="currentRegistro.ejercicio"
        />
      </div>
      
      <div class="form-group">
        <label for="description">Fecha</label>
        <input type="text" class="form-control" id="fecha"
          v-model="currentRegistro.fecha"
        />
      </div>

    <div class="form-group">
        <label for="title">Reps.</label>
        <input type="text" class="form-control" id="repeticiones"
          v-model="currentRegistro.repeticiones"
        />
    </div>

    <div class="form-group">
        <label for="description">Peso</label>
        <input type="text" class="form-control" id="peso"
          v-model="currentRegistro.peso"
        />
    </div>

-->


    </form>

<!--
    <button class="badge badge-primary mr-2"
      v-if="currentTutorial.published"
      @click="updatePublished(false)"
    >
      UnPublish
    </button>
    <button v-else class="badge badge-primary mr-2"
      @click="updatePublished(true)"
    >
      Publish
    </button>
-->
    <button class="badge badge-danger mr-2"
      @click="deleteEjercicio"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
      @click="updateEjercicio"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Selecciona un Ejercicio...</p>
  </div>
</template>

<script>
import EjercicioDataService from "../../services/EjercicioDataService";

export default {
  name: "registroEj",
  data() {
    return {
      currentEjercicio: null,
      message: ''
    };
  },
  methods: {
    getRegistro(id) {
      EjercicioDataService.get(id)
        .then(response => {
          this.currentEjercicio = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
/*
    updatePublished(status) {
      var data = {
        id: this.currentEjercicio.id,
        title: this.currentEjercicio.title,
        description: this.currentEjercicio.description,
        published: status
      };

      EjercicioDataService.update(this.currentEjercicio.id, data)
        .then(response => {
          this.currentEjercicio.published = status;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
*/
    updateEjercicio() {
      EjercicioDataService.update(this.currentEjercicio.id, this.currentEjercicio)
        .then(response => {
          console.log(response.data);
          this.message = 'The Ejercicio was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteEjercicio() {
      EjercicioDataService.delete(this.currentEjercicio.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "ejercicios" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getEjercicio(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
