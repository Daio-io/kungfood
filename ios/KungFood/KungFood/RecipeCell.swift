//
//  RecipeCell.swift
//  KungFood
//
//  Created by Dai on 03/11/2018.
//  Copyright © 2018 Daio. All rights reserved.
//

import UIKit

class RecipeCell: UITableViewCell {
    
    
    @IBOutlet weak var recipeImage: UIImageView!
    @IBOutlet weak var recipeText: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
