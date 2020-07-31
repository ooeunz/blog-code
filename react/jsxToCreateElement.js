const element = (
  <a key="key1" style={{ width: 100 }} href="http://google.com">click me</a>
);
const element = React.createElement(
  'a',
  {
    key: 'keys',
    style: { width: 100 },
    href: 'http://google.com',
  },
  'click me'
);

