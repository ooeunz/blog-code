const square = function(num) {
  return num ** 2;
};

const sumAndSquare = function(x, y) {
  return square(x + y);
};

console.log(sumAndSquare(1, 2));
