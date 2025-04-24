<template>
  <div class="calendar">
    <!-- Calendar Header -->
    <div class="calendar-header">
      <div class="month-controls">
        <div class="nav-lozenge">
          <button @click="prevMonth">&lt;</button>
          <button @click="nextMonth">&gt;</button>
        </div>
        <button class="today-btn" @click="goToToday">Today</button>
      </div>
      <div class="month-name">{{ monthName }}</div>
      <div class="view-toggle">
        <button :class="{ active: view === 'month' }" @click="setView('month')">Month</button>
        <button :class="{ active: view === 'week' }" @click="setView('week')">Week</button>
        <button :class="{ active: view === 'day' }" @click="setView('day')">Day</button>
      </div>
    </div>

    <div v-if="view === 'month'" class="calendar-grid">
      <div class="day-name" v-for="(day, index) in weekDays" :key="'dayname-' + index">{{ day }}</div>

      <div
          v-for="(day, index) in monthGrid"
          :key="'calendar-day-' + index"
          class="calendar-day"
          :class="{ today: isToday(day.date), empty: day.day === null }"
      >
        <div
            v-if="day.day !== null"
            class="day-number"
            :class="{ todayNumber: isToday(day.date) }"
        >
          {{ day.day }}
        </div>
      </div>
    </div>
    <div v-if="view === 'week'" class="calendar-week-view">
      <p>Week view is under construction...</p>
    </div>

    <div v-if="view === 'day'" class="calendar-day-view">
      <p>Day view is under construction...</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      view: 'month',
      currentDate: new Date(),
      weekDays: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
    };
  },
  computed: {
    firstDayOfMonth() {
      return new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), 1).getDay();
    },
    numberOfDaysInMonth() {
      return new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1, 0).getDate();
    },
    monthName() {
      return this.currentDate.toLocaleString('default', {month: 'long', year: 'numeric'});
    },
    rawMonthDays() {
      const days = [];
      const firstDay = this.firstDayOfMonth;
      const numberOfDays = this.numberOfDaysInMonth;

      for (let i = 0; i < firstDay; i++) {
        days.push(null);
      }

      for (let i = 1; i <= numberOfDays; i++) {
        days.push({
          day: i,
          date: new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), i),
        });
      }

      return days;
    },
    monthGrid() {
      return this.rawMonthDays.map((day) => (day === null ? {day: null, date: null} : day));
    },
  },
  methods: {
    setView(view) {
      this.view = view;
    },
    isToday(date) {
      if (!date) return false;
      const today = new Date();
      return (
          date.getDate() === today.getDate() &&
          date.getMonth() === today.getMonth() &&
          date.getFullYear() === today.getFullYear()
      );
    },
    prevMonth() {
      const date = new Date(this.currentDate);
      date.setMonth(date.getMonth() - 1);
      this.currentDate = date;
    },
    nextMonth() {
      const date = new Date(this.currentDate);
      date.setMonth(date.getMonth() + 1);
      this.currentDate = date;
    },
    goToToday() {
      this.currentDate = new Date();
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');

.calendar {
  width: 90%;
  margin: auto;
  text-align: center;
  font-family: 'Poppins', sans-serif;
}

.calendar-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  position: relative;
}

.month-controls {
  display: flex;
  align-items: center;
  gap: 10px;
}

.nav-lozenge {
  display: flex;
  border-radius: 25px;
  overflow: hidden;
  border: 1px solid #007BFF;
}

.nav-lozenge button {
  background: white;
  border: none;
  padding: 8px 12px;
  cursor: pointer;
  font-weight: 600;
  color: #007BFF;
  transition: background 0.3s;
}

.nav-lozenge button:hover {
  background-color: #e0e0ff;
}

.today-btn {
  background-color: #007BFF;
  color: white;
  border: none;
  padding: 8px 16px;
  border-radius: 20px;
  cursor: pointer;
  transition: background 0.3s;


}

.today-btn:hover {
  background-color: #0056b3;
}

.month-name {
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  flex-grow: 1; /* Ensures month name takes remaining space */
}

.view-toggle {
  position: absolute;
  right: 0;
  display: flex;
  border-radius: 25px;
  overflow: hidden;
  border: 1px solid #007BFF;
}

.view-toggle button {
  flex: 1;
  padding: 8px 16px;
  background: white;
  border: none;
  cursor: pointer;
  color: #007BFF;
  font-weight: 500;
  transition: background 0.3s, color 0.3s;
}

.view-toggle button:not(:last-child) {
  border-right: 1px solid #007BFF;
}

.view-toggle button.active {
  background-color: #007BFF;
  color: white;
}
.view-toggle button:hover {
  background-color: #e0e0ff;
}

.calendar-grid {
  display: grid;
  grid-template-columns: repeat(7, 1fr);
  grid-gap: 5px;
  text-align: center;
  padding: 10px 0;
}

.day-name {
  font-weight: bold;
  padding: 5px 0;
  background-color: #eaeaea;
}

.calendar-day {
  position: relative;
  padding: 12px 0;
  background-color: #f4f4f4;
  border-radius: 5px;
  min-height: 60px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.calendar-day:not(.empty):hover {
  background-color: #d0e6ff;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.day-number {
  position: absolute;
  top: 5px;
  right: 8px;
  font-size: 14px;
  font-weight: bold;
}

.calendar-day.today {
  //background-color: #ffffff;
  //border: 2px solid #0000ba;

}
.day-number.todayNumber {

  border-radius: 50%;
  width: 28px;
  height: 28px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 600;
  font-size: 14px;
  border: 2px solid rgba(0, 0, 186, 0.76);
}

.calendar-day.empty {
  background-color: transparent;
  cursor: default;
}

.calendar-week-view,
.calendar-day-view {
  margin-top: 20px;
}
</style>

