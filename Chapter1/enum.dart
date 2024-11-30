import 'dart:developer';
import 'dart:io';

void main() {
  String? card = stdin.readLineSync();
  // if (card!.toLowerCase() == cardType.draft.toString().toLowerCase()) {
  //   print('Card is draft');
  // } else {
  //   print("Card is not draft type");
  // }
  switch (card) {
    case cardType.draft:
      print("Card is draft");
    default:
      print("Card is not draft");
  }
}

enum cardType { draft, published, deprecated }
