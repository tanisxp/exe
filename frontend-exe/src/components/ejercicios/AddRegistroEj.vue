<template>
  <div class="submit-form2">

    <div id="resp-table">
      <div id="resp-table-caption">
        <div id="resp-table-header">
          <div class="table-header-cell">Id</div>
          <div class="table-header-cell">Fecha</div>
          <div class="table-header-cell">Ejercicio</div>
          <div class="table-header-cell">Peso</div>
          <div class="table-header-cell">Reps.</div>
          <div class="table-header-cell">Tiempo</div>
          <div class="table-header-cell">Distancia</div>
          <div class="table-header-cell">Observaciones</div>
       
        </div>
             
 
        <div id="resp-table-body">
          <div class="resp-table-row">
            <div class="table-body-cell"><input type="text" class="form-control" id="id" required v-model="registro.id" name="id"/></div>
         <!--   <div class="table-body-cell"><input type="text" class="form-control" id="fechaEjecucion" required v-model="registro.fechaEjecucion" name="fechaEjecucion"/></div>-->
<!--
<datetime
  type="datetime"
  v-model="registro.fechaEjecucion"
  input-class="my-class"
  value-zone="America/New_York"
  zone="Asia/Shanghai"
  :format="{ year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: '2-digit', timeZoneName: 'short' }"
  :phrases="{ok: 'Continue', cancel: 'Exit'}"
  :hour-step="2"
  :minute-step="15"
  :week-start="7"
  use12-hour
  auto
  ></datetime>
    -->

<div class="table-body-cell"><input type="date"  id="fechaEjecucion" required v-model="registro.fechaEjecucion" name="fechaEjecucion"/></div>


      

            <!--<div class="table-body-cell"><input type="search" class="form-control" id="ejercicio" required v-model="registro.ejercicio"  list="Ejercicio" name="ejercicio"/></div>-->
            <div class="table-body-cell">
             

              <select v-model="registro.ejercicio" >
                <option>A</option>
                <option>B</option>
                <option>C</option>
              </select>
            </div>

            <div class="table-body-cell"><input type="text" class="form-control" id="peso"  v-model="registro.peso" name="peso"/></div>
            <div class="table-body-cell"><input type="text" class="form-control" id="repeticiones"  v-model="registro.repeticiones" name="repeticiones"/></div>
            <div class="table-body-cell"><input type="text" class="form-control" id="tiempo"  v-model="registro.tiempo" name="tiempo"/></div>
            <div class="table-body-cell"><input type="text" class="form-control" id="distancia"  v-model="registro.distancia" name="distancia"/></div>
            <div class="table-body-cell"><input type="text" class="form-control" id="observaciones"  v-model="registro.observaciones" name="observaciones"/></div>
            <div class="table-body-cell" style="text-align:right"><button @click="saveRegistro" class="btn btn-success">Submit</button></div>      
            <div class="table-body-cell"><button class="m-3 btn btn-sm btn-danger" @click="removeAllRegistros">Remove All</button></div>           
          </div>

          <br/>

      

          <div class="resp-table-row" :class="{ active: resp-table-row2 }" v-for="(registro,index) in registros" v-bind:key="index" @click="mensaje(index)">
            <div class="table-body-cell" style="text-align:left; border:1px solid #F1F1F1;"> {{ registro.id }}</div>
            <div class="table-body-cell" style="text-align:left; border:1px solid #F1F1F1 ;"> {{ registro.fechaEjecucion }}</div>
            <div class="table-body-cell" style="text-align:left; border:1px solid #F1F1F1;"> {{ registro.ejercicio }}</div>
            <div class="table-body-cell" style="text-align:left; border:1px solid #F1F1F1;"> {{ registro.peso }}</div>
            <div class="table-body-cell" style="text-align:left; border:1px solid #F1F1F1;"> {{ registro.repeticiones }}</div>
            <div class="table-body-cell" style="text-align:left; border:1px solid #F1F1F1;"> {{ registro.tiempo }}</div>
            <div class="table-body-cell" style="text-align:left; border:1px solid #F1F1F1;"> {{ registro.distancia }}</div>
            <div class="table-body-cell" style="text-align:left; border:1px solid #F1F1F1 ;"> {{ registro.observaciones }}</div>
        </div>

        </div>
      </div>
    </div>

  <!-- LISTA DE RESULTADOS -->
  <!--  <Reg :key="listaResultados"></Reg>-->
  <!--
    <VueTailWindPicker          
              :init="false"
              @change="(v) => value = v">
              <input v-model="registro.fechaEjecucion" placeholder="Example initial value">
          </VueTailWindPicker>
          -->
  </div>
</template>



<style type="application/javascript">
#resp-table {
  width: 100%;
  display: table;
}

#resp-table-caption {
  display: table-caption;
  text-align: center;
  font-size: 20px;
  font-weight: bold;
}

#resp-table-header {
  display: table-header-group;
  background-color: gray;
  font-weight: bold;
  text-align: center;
  font-size: 20px;
}

.table-header-cell {
  display: table-cell;
  padding: 10px;
  text-align: justify;
  border-bottom: 1px solid black;
}

#resp-table-body {
  display: table-row-group;
}

.resp-table-row {
  display: table-row;
}
.resp-table-row2 {
  display: table-row;
  border: 1px solid black;
}


.table-body-cell {
  display: table-cell;
  font-weight: normal;
  font-size: large;
}
</style>  

<script>


/*import Reg from './RegistroList' */ /* de aquí se importan las listas de resultados*/

import RegistroDataService from "../../services/RegistroDataService";
//import { Datetime } from 'vue-datetime';


export default {/*
  components: {
    Reg
  },*/
  components: { 
   // datetime: Datetime,
   // VueTailWindPicker: () => import('vue-tailwind-picker'),     
    },
  name: "add-registro",  
  data() {
    return {
      registro: {
        id: null,
        fechaEjecucion: null, 
        ejercicio: "",
        peso: 0,
        repeticiones: 0,
        tiempo:0,
        distancia:0,
        observaciones:""
      },
      submitted: false,
      registros:[]
    };
  },
  methods: {
      retrieveRegistros() {
          console.log("retrieveRegistros");
          RegistroDataService.getAll()
              .then(response => {
                this.registros = response.data;
                console.log(response.data);
              })
              .catch(e => {
                console.log(e);
              });
      },
      saveRegistro() {
        var data = {
          id: this.registro.id,
          fechaEjecucion: this.registro.fechaEjecucion, 
          ejercicio: this.registro.ejercicio,
          peso: this.registro.peso,
          repeticiones: this.registro.repeticiones,
          tiempo: this.registro.tiempo,
          distancia: this.registro.distancia,
          observaciones: this.registro.observaciones      
        };

        RegistroDataService.create(data)
          .then((response) => {
            this.registro.id = response.data.id;        
            this.submitted = true;
        //   this.listaResultados += 1; /*esto sirve para recargar el componente de la lista de resultados*/ 
          })
          .catch((e) => {
            console.log(e);
          }).finally(() => {
            this.registro = {};
            this.retrieveRegistros();
          });
      },   
      
      removeAllRegistros() {
        RegistroDataService.deleteAll()
          .then(response => {
            console.log(response.data);
            this.retrieveRegistros();
          })
          .catch(e => {
            console.log(e);
          });
    },
    mensaje(index) {
    console.log(index);
      document.getElementById("p2").style.color="blue";
    },

    },
    mounted(){
      this.retrieveRegistros();
      console.log("mounted");
    }
  };

</script>

<style src="../../assets/tailwind.css"/>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>
