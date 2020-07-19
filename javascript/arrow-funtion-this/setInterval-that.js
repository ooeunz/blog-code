function ConstructorSample() {
  this.count = 1;
  var that = this
  setInterval(function increase() {
    that.count++;
  }, 1000);
}

const obj = new ConstructorSample();