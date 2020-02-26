//
//  Deck.swift
//  CardDeck
//
//  Created by William Brubaker on 2/25/20.
//  Copyright © 2020 noncreature0714. All rights reserved.
//

import Foundation

class Deck {
    var cards = [Card?](repeating: nil, count: 52);
    
    
    init(){
        for suite in Suite.allValues {
            for rank in Rank.allValues {
                print("suite: \(suite.rawValue) and rank \(rank.rawValue)")
            }
        }
        
//        print("some card \(decod)")
    }
    
    func shuffle() {
        
    }
    
    func cut(at cutLocation: Int ) {
        
    }
    
    func sort() {
        
    }
    
    func reset() {
        
    }
    
    func deal() -> Card {
        return Card(card: "🂡")
    }
    
    func peek() -> Card {
        return Card(card: "🂽")
    }
}
