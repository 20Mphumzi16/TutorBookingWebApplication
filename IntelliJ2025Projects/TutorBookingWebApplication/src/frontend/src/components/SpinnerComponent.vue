<template>
<div class="loader"></div>

</template>
<script >
export default {
  name:"SpinnerComponent"
}



</script>

<style scoped>
.loader {
  width: 50px;
  aspect-ratio: 1;
  box-shadow: 0 0 0 3px #7d2ae8 inset;
  border-radius: 50%;
  position: relative;
}
.loader:before,
.loader:after {
  content: "";
  position: absolute;
  top: 5px;
  left: calc(50% - 12.5px);
  box-shadow: inherit;
  width: 25px;
  aspect-ratio: 1;
  border-radius: 50%;
  transform-origin: 50% calc(100% - 5px);
  animation: l7 1.5s linear infinite;
}
.loader:after {
  top: calc(100% + 2px);
  transform-origin: 50% -27px;
  animation-delay: -0.75s;
}
@keyframes l7 {
  to {
    transform: rotate(360deg);
  }
}
</style>