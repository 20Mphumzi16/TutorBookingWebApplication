<template>
  <div class="calendar">

    <div class="calendar-header">
      <div class="month-controls">
        <div class="nav-lozenge">
          <button @click="view === 'week' ? prevWeek() : view === 'day' ? prevDay() : prevMonth()">&lt;</button>
          <button @click="view === 'week' ? nextWeek() : view === 'day' ? nextDay() : nextMonth()">&gt;</button>
        </div>
        <button class="today-btn" @click="goToToday">Today</button>
      </div>
      <div class="month-name">
        {{ view === 'month' ? monthName : (view === 'day' ? currentDate.toLocaleDateString('default', { month: 'short' }).toUpperCase() + ' ' + currentDate.getDate() + ', ' + currentDate.getFullYear() : weekRangeHeader) }}
      </div>
      <div class="view-toggle">
        <button :class="{ active: view === 'month' }" @click="setView('month')">Month</button>
        <button :class="{ active: view === 'week' }" @click="setView('week')">Week</button>
        <button :class="{ active: view === 'day' }" @click="setView('day')">Day</button>
      </div>
    </div>



    <!-- Month View -->
    <div v-if="view === 'month'" class="calendar-grid">
      <div class="day-name" v-for="(day, index) in weekDays" :key="'dayname-' + index">{{ day }}</div>

      <div
          v-for="(day, index) in monthGrid"
          :key="'calendar-day-' + index"
          class="calendar-day"
          :class="{ today: isToday(day.date), empty: day.day === null }"
      >
        <div v-if="day.day !== null" class="day-content">
          <div class="day-number" :class="{ todayNumber: isToday(day.date) }">{{ day.day }}</div>
          <div v-for="(session, idx) in day.sessions" :key="idx" class="session-pill">
            {{ session.time }} {{ session.name }}
          </div>
        </div>
      </div>
    </div>

    <!-- Week View -->
    <div v-if="view === 'week'" class="calendar-week-view">
      <div class="week-header">
      </div>
      <div class="week-days-row">
        <div class="week-day" v-for="(date, index) in currentWeekDates" :key="'week-' + index">
          {{ weekDays[index].toUpperCase() }} {{ date.getDate().toString().padStart(2, '0') }}/{{ (date.getMonth() + 1).toString().padStart(2, '0') }}
        </div>
      </div>
      <div class="week-dates-row">
        <div
            v-for="(date, index) in currentWeekDates"
            :key="'week-date-' + index"
            class="calendar-day"
            :class="{ today: isToday(date) }"
        >
          <div class="day-content">
            <div class="day-number" :class="{ todayNumber: isToday(date) }">
              {{ date.getDate() }}
            </div>
            <div
                v-for="(session, idx) in getSessionsForDate(date)"
                :key="idx"
                class="session-pill"
            >
              {{ session.time }} {{ session.name }}
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Reused grid layout for day view -->
    <div v-if="view === 'day'" class="calendar-grid day-view-grid">
      <!-- Only one column: the current day -->
      <div class="day-name" style="grid-column: span 7; text-align: center;">
        {{ currentDate.toLocaleDateString('default', { weekday: 'long' }).toUpperCase() }}
      </div>

      <div class="calendar-day" style="grid-column: span 7;" :class="{ today: isToday(currentDate) }">
        <div class="day-content">
          <div class="day-number todayNumber">
            {{ currentDate.getDate() }}
          </div>
          <div v-for="(session, idx) in getSessionsForDate(currentDate)" :key="idx" class="session-pill">
            {{ session.time }} {{ session.name }}
          </div>
        </div>
      </div>
    </div>
</div>
</template>

<script>
export default {
  name: 'CalenderComponent',
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
      return this.currentDate.toLocaleString('default', { month: 'long', year: 'numeric' });
    },
    rawMonthDays() {
      const days = [];
      const firstDay = this.firstDayOfMonth;
      const numberOfDays = this.numberOfDaysInMonth;

      for (let i = 0; i < firstDay; i++) {
        days.push(null);
      }

      for (let i = 1; i <= numberOfDays; i++) {
        const date = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), i);
        // Mocked sessions
        const sessions = [];
        if (i === 5) sessions.push({ time: '7am', name: 'Malik' });
        if (i === 10) sessions.push({ time: '7am', name: 'Malik' }, { time: '12pm', name: 'Lwethu' }, { time: '2pm', name: 'Siya' });
        if (i === 24) sessions.push({ time: '7am', name: 'Sinesipho' });
        days.push({ day: i, date, sessions });
      }

      return days;
    },
    monthGrid() {
      return this.rawMonthDays.map((day) =>
          day === null ? { day: null, date: null, sessions: [] } : day
      );
    },
    currentWeekDates() {
      const current = new Date(this.currentDate);
      const startOfWeek = new Date(current.setDate(current.getDate() - current.getDay()));
      const days = [];

      for (let i = 0; i < 7; i++) {
        const day = new Date(startOfWeek);
        day.setDate(startOfWeek.getDate() + i);
        days.push(day);
      }

      return days;
    },
    weekRangeHeader() {
      if (this.currentWeekDates.length === 0) return '';
      const start = this.currentWeekDates[0];
      const end = this.currentWeekDates[6];
      return `${start.toLocaleString('default', { month: 'short' }).toUpperCase()} ${start.getDate()}–${end.getDate()}, ${end.getFullYear()}`;
    },

  },
  methods: {
    setView(view) {
      this.view = view;
    },
    getSessionsForDate(date) {
      const day = date.getDate();
      const sessions = [];
      if (day === 5) sessions.push({ time: '7am', name: 'Malik' });
      if (day === 10) {
        sessions.push({ time: '7am', name: 'Malik' });
        sessions.push({ time: '12pm', name: 'Lwethu' });
        sessions.push({ time: '2pm', name: 'Siya' }); // Add the missing session
      }
      if (day === 24) sessions.push({ time: '7am', name: 'Sinesipho' });
      return sessions;
    },
    // Week Navigation
    prevWeek() {
      const date = new Date(this.currentDate);
      date.setDate(date.getDate() - 7); // Move back 7 days (previous week)
      this.currentDate = date;
    },

    nextWeek() {
      const date = new Date(this.currentDate);
      date.setDate(date.getDate() + 7); // Move forward 7 days (next week)
      this.currentDate = date;
    },

    // Day Navigation
    prevDay() {
      const date = new Date(this.currentDate);
      date.setDate(date.getDate() - 1); // Move back 1 day (previous day)
      this.currentDate = date;
    },
    nextDay() {
      const date = new Date(this.currentDate);
      date.setDate(date.getDate() + 1); // Move forward 1 day (next day)
      this.currentDate = date;
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
  flex-grow: 1;
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
  text-align: left;
  padding: 10px 0;
}

.day-name {
  font-weight: bold;
  background-color: #007BFF;
  color: white;
  text-align: center;
  padding: 10px;
  border-radius: 8px;
  font-size: 14px;
}

.calendar-day{
  position: relative;
  background-color: #f4f4f4;
  border-radius: 5px;
  min-height: 85px;
  display: flex;
  flex-direction: column;
  padding: 6px;
  height: auto;
}

.calendar-day:not(.empty):hover {
  background-color: #d0e6ff;
  cursor: pointer;
  transition: background-color 0.3s ease;
}


.day-content {
  display: flex;
  flex-direction: column;
  gap: 4px;
  align-items: flex-start;
  width: 100%;
}

.day-number,.week-days-row {
  font-size: 14px;
  font-weight: bold;
  align-self: flex-end;
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


.session-pill {
  display: block;                 /* Make it fill the width like a block element */
  width: 100%;                    /* Full width of the parent */
  background-color: rgba(64, 0, 255, 0.73);
  color: #ffffff;
  border-radius: 2px;
  padding: 4px 8px;
  font-size: 12px;
  font-weight: 500;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  box-sizing: border-box;        /* Make sure padding doesn't cause overflow */
}


.calendar-day.empty {
  background-color: transparent;
  cursor: default;
}

.calendar-week-view,
.calendar-day-view {
  margin-top: 20px;
}

/* Week View */
.week-header h2 {
  font-size: 20px;
  font-weight: 600;
  margin-bottom: 10px;
}
.week-days-row {
  display: flex;
  justify-content: space-between;
  gap: 5px;
}
.week-day {
  flex: 1;


  text-align: center;



  font-weight: bold;
  background-color: #007BFF;
  color: white;

  padding: 10px;
  border-radius: 8px;
  font-size: 14px;
}
.week-dates-row {
  display: flex;
  justify-content: space-between;
  margin-top:5px;
  gap: 5px;
}
.week-dates-row .calendar-day {
  flex: 1;
}

/* Day View */
.day-header h2 {
  font-size: 20px;
  font-weight: 600;
  margin-bottom: 10px;
}
.day-single-cell {
  background-color: #e6f7ff;
  border-radius: 8px;
  padding: 40px;
  text-align: center;
  font-size: 16px;
  font-weight: 500;
}
</style>
