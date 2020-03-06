const time1 = setTimeout(function() {
  console.log('1.5초 후에 실행');
}, 1500);

const time2 = setTimeout(() => {
  console.log('1.5초 후에 실행');
}, 1500);
