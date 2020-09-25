<template>
  <div v-if="currentEjercicio" class="edit-form">
    <h4>Ejercicio</h4>
    <form>

      <div class="form-group">
        <label for="title">Id</label>
        <input type="text" class="form-control" id="id"
          v-model="currentEjercicio.id"
        />
      </div>    
    
      <div class="form-group">
        <label for="title">Nombre</label>
        <input type="text" class="form-control" id="nombre"
          v-model="currentEjercicio.nombre"
        />
      </div>
      
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="descripcion"
          v-model="currentEjercicio.descripcion"
        />
      </div>

    <div class="form-group">
        <label for="title">Categor&iacute;a</label>
        <input type="text" class="form-control" id="categoria"
          v-model="currentEjercicio.categoria"
        />
    </div>

    <div class="form-group">
        <label for="description">Tipo</label>
        <input type="text" class="form-control" id="tipo"
          v-model="currentEjercicio.tipo"
        />
    </div>



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
  name: "ejercicio",
  data() {
    return {
      currentEjercicio: null,
      message: ''
    };
  },
  methods: {
    getEjercicio(id) {
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
