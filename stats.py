import sys

def round_up(n):
    # round with 2 decimal places
    return round(n, 2)

def remain():
    annots_post = open("annots_post.tsv", "r").readlines()
    annots_post = [x.strip() for x in annots_post]
    
    annots_infer = open("annots_infer.tsv", "r").readlines()
    annots_infer = [x.strip() for x in annots_infer]
    
    # Find annotations that are both annots_post and in annots_infer
    both = set(annots_post).intersection(annots_infer)
    print(str(len(both)) + " (" + str(round(len(both) / len(annots_infer) * 100)) + "%)")
    

def recall():
    annots_post = open("annots_post.tsv", "r").readlines()
    annots_post = [x.strip() for x in annots_post]
    
    annots_infer = open("annots_infer.tsv", "r").readlines()
    annots_infer = [x.strip() for x in annots_infer]
    
    # calculate recall
    recall = len(set(annots_post).intersection(annots_infer)) / len(annots_post)
    print("Recall: " + str(round_up(recall * 100)) + "%")


def precision():
    annots_post = open("annots_post.tsv", "r").readlines()
    annots_post = [x.strip() for x in annots_post]
    
    annots_infer = open("annots_infer.tsv", "r").readlines()
    annots_infer = [x.strip() for x in annots_infer]
    
    # calculate precision
    precision = len(set(annots_post).intersection(annots_infer)) / len(annots_infer)
    print("Precision: " + str(round_up(precision * 100)) + "%")
    
    
if __name__ == "__main__":
    arg = sys.argv[1]
    if arg == "remain":
        remain()
    elif arg == "recall":
        recall()
    elif arg == "precision":
        precision()
    else:
        print("Invalid argument. Please use 'remain', 'recall', or 'precision'")