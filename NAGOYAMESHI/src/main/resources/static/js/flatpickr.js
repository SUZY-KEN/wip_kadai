let maxDate = new Date();
 maxDate = maxDate.setMonth(maxDate.getMonth() + 2);
 
 flatpickr('#checkinDate', {
   mode: "single",
   locale: 'ja',
   minDate: 'today',
   maxDate: maxDate
 });
