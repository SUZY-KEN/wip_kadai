let maxDate = new Date();
 maxDate = maxDate.setMonth(maxDate.getMonth() + 2);
 
let items=[1,2,3];
 
// 予約日登録用
 flatpickr('#checkinDate', {
   mode: "single",
   locale: 'ja',
   minDate: 'today',
   maxDate: maxDate,
//   disable:[
//	          function (date) {
//	            return items.includes(date.getDay())  }
//	          
//     		]
   
 });


//会社設立日編集用
 let minDate=new Date();
 flatpickr('#establishedAt', {
   mode: "single",
   locale: 'ja',
   minDate: '1800-01-01',
   maxDate: minDate
 });