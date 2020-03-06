if (true) {
  var x = 'var로 선언한 변수입니다.';
}

console.log(x); // (출력값) var로 선언한 변수입니다.

if (true) {
  const y = 'const로 선언한 변수입니다.';
}

console.log(y); // (출력값) ReferenceError: y is not defined
