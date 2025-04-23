<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="w-full max-w-sm bg-white p-8 rounded-2xl shadow-xl">
      <h2 class="text-2xl font-bold text-center mb-6">Login</h2>

      <form @submit.prevent="handleLogin">
        <!-- Username -->
        <div class="mb-4">
          <label class="block mb-1 font-medium" for="username">Username</label>
          <input
              type="text"
              id="username"
              v-model="username"
              required
              class="w-full px-4 py-2 border rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-400"
          />
        </div>

        <!-- Password with toggle -->
        <div class="mb-4 relative">
          <label class="block mb-1 font-medium" for="password">Password</label>
          <input
              :type="showPassword ? 'text' : 'password'"
              id="password"
              v-model="password"
              required
              class="w-full px-4 py-2 border rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-400"
          />
          <span
              class="absolute right-3 top-9 cursor-pointer text-gray-500"
              @click="showPassword = !showPassword"
          >
            <svg
                v-if="showPassword"
                xmlns="http://www.w3.org/2000/svg"
                class="h-5 w-5"
                viewBox="0 0 20 20"
                fill="currentColor"
            >
              <path
                  d="M4.03 4.97a9.01 9.01 0 0111.94 0l1.414-1.414A10.972 10.972 0 0010 2C6.417 2 3.266 4.417 1.636 7.636l1.414 1.414a9.003 9.003 0 011.98-2.08zM10 6a4 4 0 100 8 4 4 0 000-8zm0 2a2 2 0 110 4 2 2 0 010-4zm-7.05.637l-1.414 1.414a10.97 10.97 0 001.88 2.186l1.415-1.415a8.002 8.002 0 01-1.88-2.185zM10 18c3.583 0 6.734-2.417 8.364-5.636l-1.414-1.414a9.003 9.003 0 01-11.94 0l-1.414 1.414A10.972 10.972 0 0010 18z"
              />
            </svg>
            <svg
                v-else
                xmlns="http://www.w3.org/2000/svg"
                class="h-5 w-5"
                viewBox="0 0 20 20"
                fill="currentColor"
            >
              <path
                  fill-rule="evenodd"
                  d="M10 4.5c-3.038 0-5.66 1.96-7.188 5 1.528 3.04 4.15 5 7.188 5s5.66-1.96 7.188-5c-1.528-3.04-4.15-5-7.188-5zM10 13a3 3 0 100-6 3 3 0 000 6z"
                  clip-rule="evenodd"
              />
            </svg>
          </span>
        </div>

        <!-- Submit Button -->
        <button
            type="submit"
            class="w-full py-2 mt-4 bg-blue-500 text-white font-semibold rounded-xl hover:bg-blue-600 transition"
        >
          Login
        </button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginPage",
  data() {
    return {
      username: "",
      password: "",
      showPassword: false,
    };
  },
  methods: {
    handleLogin() {
      // Handle login API call
      console.log("Logging in with", this.username, this.password);
    },
  },
};
</script>

<style scoped>
body {
  font-family: 'Inter', sans-serif;
}
</style>
