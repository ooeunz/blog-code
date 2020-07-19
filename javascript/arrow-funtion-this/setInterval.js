function ConstructorSample() {
  this.count = 1;
  setInterval(function increase() {
    this.count++;
  }, 1000);
}

const obj = new ConstructorSample();
console.log(obj.count);