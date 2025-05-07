<!-- components/Sidebar.vue -->
<template>
  <aside class="w-64 h-full bg-gray-800 text-white p-4">
    <div class="text-xl font-bold mb-6">📚 Tutor App</div>
    <ul class="space-y-4">
      <li
          v-for="item in menuItems"
          :key="item.name"
          :class="['cursor-pointer', selected === item.name ? 'font-bold text-blue-400' : '']"
          @click="$emit('select', item.name)"
      >
        {{ item.label }}
      </li>
    </ul>
  </aside>
</template>

<script setup>
const props = defineProps({
  selected: String,
});

const menuItems = [
  { name: 'Dashboard', label: '🏠 Dashboard' },
  { name: 'BookSession', label: '📅 Book a Session' },
  { name: 'MySessions', label: '🗂 My Sessions' },
  { name: 'Materials', label: '📁 Lesson Materials' },
  { name: 'Messages', label: '💬 Messages' },
  { name: 'Settings', label: '⚙️ Settings' },
];
</script>
