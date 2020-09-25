<style scoped>
.dropbtn {
  background-color: #343a40!important;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: #343a40!important;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown {
  float:left;
  align-content: center;
}

.dropdown-content a:hover {background-color: #cccc;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: black;}
</style>


<template>
  <div id="app">

    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <a href="#" class="navbar-brand" style="padding-left:15%"></a>

      <div class="navbar-nav mr-auto">       

          <div class="dropdown">
              <button class="dropbtn">Ejercicios</button>
              <div class="dropdown-content">
                <a href="/ejercicios" class="nav-link">Ejercicios</a>
                <a href="/addEjercicio" class="nav-link">Nuevo ejercicio</a>            
                <a href="/addRegistroEj" class="nav-link">Registro ejercicios</a>
              </div>
          </div>

          <div class="dropdown">
              <button class="dropbtn">Alimentaci&oacute;n</button>
              <div class="dropdown-content">
                <a href="/ejercicios" class="nav-link">Ejercicios</a>
                <a href="/addEjercicio" class="nav-link">Nuevo ejercicio</a>            
              </div>
          </div>

      </div>
     
    </nav>


    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>
