<template>
  <!-- footer -->
  <footer class="footer">
    <div class="container">
      <div class="row row-grid align-items-center"></div>
      <hr />
      <div class="row align-items-center justify-content-md-between">
        <div class="col-md-6 float-left">
          <div class="copyright" style="color: gray">
            Copyright &copy; {{ year }} SSAFY PROJECT <br />
          </div>
          <div style="color: gray">Developer - An yeaji / Heo beom</div>
          <div>
            <span style="color: gray"
              >associate prof a.k.a Debug Machine Han</span
            >
          </div>
        </div>
        <div class="col-md-6">
          <ul class="nav nav-footer justify-content-end">
            <li class="nav-item">
              <a href="#" class="nav-link" target="_blank" rel="noopener"
                >HappyHouse</a
              >
            </li>
            <li class="nav-item">
              <a
                href="https://www.ssafy.com"
                class="nav-link"
                target="_blank"
                rel="noopener"
                >SSAFY</a
              >
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
</template>
<script>
export default {
  name: "app-footer",
  data() {
    return {
      year: new Date().getFullYear(),
    };
  },
};
</script>
<style></style>
