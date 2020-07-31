class SampleComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      grade: props > 90 ? 'A' : 'B',
    };
  }
}

class SampleComponent extends React.Component {
  state = {
    grade: props > 90 ? 'A' : 'B',
  };
}

function SampleComponent({ title }) {
  return title.length > 0 && <p>{title}</p>
}

class SampleComponent extends React.Component {
  shouldComponentUpdate(nextProps, nextState) {
    const { age } = this.state;
    return age !== nextState.age;
  }
}