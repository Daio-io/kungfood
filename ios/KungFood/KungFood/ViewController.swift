//
//  ViewController.swift
//  KungFood
//
//  Created by Dai on 03/11/2018.
//  Copyright © 2018 Daio. All rights reserved.
//

import UIKit
import common
import Kingfisher

class ViewController: UIViewController, HomeView, UITableViewDelegate, UITableViewDataSource {
    
    private var data : [Recipe] = []
    private weak var tableVuew: UITableView!

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return data.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let recipe = data[indexPath.row]
        let cellIdentifier = "RecipeCellId"
        let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! RecipeCell
        
        cell.recipeText.text = recipe.title
        if (!recipe.image.isEmpty) {
            let url = URL(string: recipe.image)!
            cell.recipeImage.kf.setImage(with: url)
        }
        return cell
    }
    
    
    private let presenter = Presenter()
    
    func error(message: String) {
        print(message)
        
    }
    
    var isLoading: Bool = false
    
    func setData(data: Response) {
        self.data = data.result
        tableVuew.reloadData()
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.setView(homeView: self)
        let tableView = UITableView(frame: view.bounds)
        
        view.addSubview(tableView)
        self.tableVuew = tableView
        tableView.dataSource = self
        tableView.delegate = self
        tableView.register(UINib(nibName: "RecipeCell", bundle: nil), forCellReuseIdentifier: "RecipeCellId")
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return CGFloat(200)
    }
    
}
