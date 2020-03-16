const longTime = () => {
  // 시간이 오래 걸리는 작업이 있다는 가정
  console.log('시간이 오래 걸리는 작업');
};

console.log('시작');
setTimeout(longTime, 0);
console.log('종료');
