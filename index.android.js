/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';
import Modal from "react-native-modalbox";
import ProgressBar from "./src/loaders/ProgressBar.android";

var codePush = require('react-native-code-push');


export class Receipt extends Component {

    constructor(props) {
    super(props);
    this.state = {
      showDownloadingModal: false,
      showInstalling: false,
      downloadProgress: 0
    };
  }

   componentDidMount() {
     var updateDialogOptions = {
        updateTitle: "Update event mới nào",
        optionalUpdateMessage: "Update nào",
        optionalIgnoreButtonLabel: "Không update",
        optionalInstallButtonLabel: "Ok",
    };

    codePush.sync(
      { updateDialog: updateDialogOptions,
        installMode: codePush.InstallMode.IMMEDIATE });
  }
  render() {

    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Hóa đơn
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
      </View>
    );
  }
}

export class Promotion extends Component {

    constructor(props) {
    super(props);
    this.state = {
      showDownloadingModal: false,
      showInstalling: false,
      downloadProgress: 0
    };
  }

   componentDidMount() {
     var updateDialogOptions = {
        updateTitle: "Update event mới nào",
        optionalUpdateMessage: "Update nào",
        optionalIgnoreButtonLabel: "Không update",
        optionalInstallButtonLabel: "Ok",
    };

    codePush.sync(
      { updateDialog: updateDialogOptions,
        installMode: codePush.InstallMode.IMMEDIATE });
  }
  render() {

    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Khuyến mãi
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
      </View>
    );
  }
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('Receipt', () => Receipt);
AppRegistry.registerComponent('Promotion', () => Promotion);


