// 함수 표현식으로 exFunc함수 생성
const exFunc = function(parameterFunc) {
  parameterFunc();
};

// exFunc 함수 실행
exFunc(function() {
  console.log(
    '이 출력값은 exFunc의 매개변수로 들어온 익명함수에서 실행됩니다.'
  );
});
// (출력값) 이 출력값은 exFunc의 매개변수로 들어온 익명함수에서 실행됩니다.
