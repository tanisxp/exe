<template>
  <div class="submit-form">
    <div v-if="!submitted">
    
     <div class="form-group">
        <label for="nombre">Id</label>
        <input
          type="text"
          class="form-control"
          id="id"
          required
          v-model="ejercicio.id"
          name="id"
        />
      </div>
    
      <div class="form-group">
        <label for="nombre">Nombre</label>
        <input
          type="text"
          class="form-control"
          id="nombre"
          required
          v-model="ejercicio.nombre"
          name="nombre"
        />
      </div>

      <div class="form-group">
        <label for="descripcion">Descripcion</label>
        <input
          class="form-control"
          id="descripcion"
          required
          v-model="ejercicio.descripcion"
          name="descripcion"
        />
      </div>

     <div class="form-group">
        <label for="categoria">Categoria</label>
        <input
          class="form-control"
          id="categoria"
          required
          v-model="ejercicio.categoria"
          name="categoria"
        />
      </div>

      <div class="form-group">
        <label for="tipo">Tipo</label>
        <input
          class="form-control"
          id="tipo"
          required
          v-model="ejercicio.tipo"
          name="tipo"
        />
      </div>

      <button @click="saveEjercicio" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newejercicio">Add</button>
    </div>
  </div>
</template>

<script>
import EjercicioDataService from "../../services/EjercicioDataService";

export default {
  name: "add-ejercicio",
  data() {
    return {
      ejercicio: {
        id: null,
        title: "",
        description: "",
        published: false
      },
      submitted: false
    };
  },
  methods: {
    saveEjercicio() {
      var data = {
		id: this.ejercicio.id,
        nombre: this.ejercicio.nombre,
        descripcion: this.ejercicio.descripcion,
        categoria: this.ejercicio.categoria,
        tipo: this.ejercicio.tipo
      };

      EjercicioDataService.create(data)
        .then(response => {
          this.ejercicio.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newejercicio() {
      this.submitted = false;
      this.ejercicio = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>
